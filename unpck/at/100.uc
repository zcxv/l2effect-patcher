class 100 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect13
		AttachOn=AM_Location
		EffectClass=Class'LineageEffect.at_stun_attack_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect15
		AttachOn=AM_LA
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_stun_attack_ta'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect10
		AttachOn=AM_Location
		EffectClass=Class'LineageEffect.at_shield_stun_cs'
	End Object
	Desc="스턴 어택" //Stun Attack
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect13',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect15',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect10',SpecificStage=0)
}