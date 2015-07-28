class 8 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=0.200000)
		EffectClass=Class'LineageEffect.mo_focus_sonic_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=0.200000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mo_focus_sonic_ta'
	End Object
	Desc="포커스 소닉" //Sonic Focus
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
}