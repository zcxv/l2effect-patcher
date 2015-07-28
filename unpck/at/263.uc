class 263 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect11
		AttachOn=AM_Location
		EffectClass=Class'LineageEffect.at_mortal_blow_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect16
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.at_fatal_strike_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect12
		AttachOn=AM_LA
		offset=(X=0.200000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.at_mortal_blow_cs'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect14
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_fatal_strike_ta'
	End Object
	Desc="데들리 블로우" //Deadly Blow
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect11',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect16',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect12',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect14',SpecificStage=0)
}