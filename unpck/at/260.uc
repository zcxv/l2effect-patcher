class 260 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.at_fatal_strike_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		AttachOn=AM_Location
		EffectClass=Class'LineageEffect.at_stun_attack_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect5
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_stun_attack_ta'
		bOnMultiTarget=True
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect6
		AttachOn=AM_Location
		EffectClass=Class'LineageEffect.at_shield_stun_cs'
		bOnMultiTarget=True
	End Object
	Desc="햄머 크러시" //Hammer Crush
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect5',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect6',SpecificStage=0)
}