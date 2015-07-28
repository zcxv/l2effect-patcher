class 4319 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect5
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.pm_lightening_strike_ta'
	End Object
	Desc="마비" //Paralysis
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect5',SpecificStage=0)
}