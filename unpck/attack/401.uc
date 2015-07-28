class 401 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect0
		AttachOn=AM_Location
		EffectClass=Class'LineageEffect.at_sting_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_Location
		EffectClass=Class'LineageEffect.at_sting_cs'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.at_fatal_strike_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		AttachOn=AM_LA
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_sting_ta'
	End Object
	Desc="저지먼트" //Judgement
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect0',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
	CastingActions(2)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
}